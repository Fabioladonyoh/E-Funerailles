import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, AbstractControl, ValidationErrors, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../../../../core/services/auth.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './register.html',
  styleUrls: ['./register.scss'],
  providers: [AuthService]
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;
  isSubmitted = false;
  isLoading = false;
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
    this.registerForm = this.formBuilder.group({
      fullName: ['', [Validators.required, Validators.pattern(/^[\wáàâäãåçéèêëíìîïñóòôöõúùûüýÿæœ'-]+\s+[\wáàâäãåçéèêëíìîïñóòôöõúùûüýÿæœ'-].*$/)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required]
    }, { 
      validators: this.passwordMatchValidator 
    });
  }

  passwordMatchValidator(control: AbstractControl): ValidationErrors | null {
    const password = control.get('password')?.value;
    const confirmPassword = control.get('confirmPassword')?.value;
    return password === confirmPassword ? null : { mismatch: true };
  }

  get f() {
    return this.registerForm.controls;
  }

  onSubmit(): void {
    this.isSubmitted = true;
    this.errorMessage = '';
    this.successMessage = '';

    if (this.registerForm.invalid) {
      if (this.f['fullName'].errors?.['pattern']) {
        this.errorMessage = 'Veuillez saisir Prénom et Nom séparés par un espace.';
      } else if (this.registerForm.errors?.['mismatch']) {
        this.errorMessage = 'Les mots de passe ne correspondent pas.';
      } else {
        this.errorMessage = 'Veuillez remplir tous les champs correctement.';
      }
      return;
    }

    this.isLoading = true;
    const { fullName, email, password } = this.registerForm.value;

    const parts = fullName.trim().split(/\s+/);
    const prenom = parts[0];
    const nom = parts.length > 1 ? parts.slice(1).join(' ') : parts[0];

    this.authService.register({ nom, prenom, email, password }).subscribe({
      next: () => {
        this.isLoading = false;
        this.successMessage = 'Compte créé avec succès ! Redirection...';
        setTimeout(() => this.router.navigate(['/login']), 2000);
      },
      error: (err) => {
        this.isLoading = false;
        if (err.status === 409) {
          this.errorMessage = 'Cet email est déjà utilisé.';
        } else if (err.status === 500) {
          // C'est ici que l'erreur ROLE_ID arrivait
          this.errorMessage = 'Erreur serveur : problème d\'attribution de rôle ou de base de données.';
        } else {
          this.errorMessage = 'Une erreur est survenue lors de l\'inscription.';
        }
        console.error('Détail erreur:', err);
      }
    });
  }
}