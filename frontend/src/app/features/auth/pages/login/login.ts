import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; // 👈 Indispensable pour les *ngIf dans ton HTML
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms'; // 👈 Ajout de ReactiveFormsModule
import { Router } from '@angular/router';
import { AuthService } from '../../../../core/services/auth.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true, // 👈 Déclaration en standalone
  imports: [CommonModule, ReactiveFormsModule,RouterLink], // 👈 Importation des modules nécessaires pour le HTML
  templateUrl: './login.html',
  styleUrls: ['./login.scss'] // (ou styleUrl: './login.scss' selon ta version d'Angular)
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  isSubmitted = false;
  errorMessage = '';

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.initForm();
  }

  // Initialisation du formulaire réactif avec des validateurs
  initForm(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  // Getter pratique pour accéder facilement aux champs dans le HTML
  get f() {
    return this.loginForm.controls;
  }

  // Méthode appelée lors de la soumission du formulaire
  onSubmit(): void {
    this.isSubmitted = true;
    this.errorMessage = '';

    // Si le formulaire est invalide, on arrête tout
    if (this.loginForm.invalid) {
      return;
    }

    const credentials = this.loginForm.value;
    console.log('Tentative de connexion avec :', credentials);

    this.authService.login(credentials).subscribe({
      next: (response) => {
        // Redirection vers le tableau de bord principal après connexion
        this.router.navigate(['/dashboard']);
      },
      error: (error) => {
        this.errorMessage = 'Identifiants incorrects. Veuillez réessayer.';
      }
    });
  }

  // Bonus : Remplir le formulaire au clic sur l'encart de démonstration
  fillDemoCredentials(): void {
    this.loginForm.patchValue({
      email: 'kofi.mensah@efunerailles.tg',
      password: 'admin123'
    });
  }
}