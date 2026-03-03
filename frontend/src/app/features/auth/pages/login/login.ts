import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms'; 
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../../../core/services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true, 
  imports: [CommonModule, ReactiveFormsModule, RouterLink], 
  templateUrl: './login.html',
  styleUrls: ['./login.scss'] 
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  isSubmitted = false;
  isLoading = false; // Pour désactiver le bouton pendant la requête
  errorMessage = '';
  successMessage = '';

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.initForm();
  }

  initForm(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  get f() {
    return this.loginForm.controls;
  }

 onSubmit(): void {
  this.isSubmitted = true;
  this.errorMessage = '';
  this.successMessage = '';

  if (this.loginForm.invalid) {
    return;
  }

  this.isLoading = true;
  const credentials = this.loginForm.value;

  this.authService.login(credentials).subscribe({
    next: (response) => {
      this.isLoading = false;
      this.successMessage = 'Connexion réussie ! Préparation de votre espace...';
      
      // On récupère l'email saisi pour la redirection
      const userEmail = credentials.email.toLowerCase();

      // Petit délai pour l'expérience utilisateur (UX)
      setTimeout(() => {
        switch (userEmail) {
          case 'admin@gmail.com':
            console.log('Accès Admin détecté');
            this.router.navigate(['/dashboard']);
            break;

          case 'agent@gmail.com':
            console.log('Accès Agent détecté');
            this.router.navigate(['/agent-dashboard']);
            break;

          case 'logisticien@gmail.com':
            console.log('Accès Logisticien détecté');
            this.router.navigate(['/logisticien-dashboard']);
            break;

          default:
            // Redirection par défaut si ce n'est aucun des trois emails spécifiques
            console.log('Utilisateur standard');
            this.router.navigate(['/user-home']); 
            break;
        }
      }, 1200);
    },
    error: (error) => {
      this.isLoading = false;
      // Gestion des messages d'erreur explicites
      if (error.status === 401) {
        this.errorMessage = 'Identifiants incorrects. Veuillez réessayer.';
      } else if (error.status === 403) {
        this.errorMessage = 'Accès refusé. Vous n\'avez pas les permissions nécessaires.';
      } else if (error.status === 0) {
        this.errorMessage = 'Le serveur est hors ligne. Vérifiez votre connexion.';
      } else {
        this.errorMessage = 'Une erreur inattendue est survenue.';
      }
    }
  });
}

  fillDemoCredentials(): void {
    this.loginForm.patchValue({
      email: 'kofi.mensah@efunerailles.tg',
      password: 'admin123'
    });
  }
}