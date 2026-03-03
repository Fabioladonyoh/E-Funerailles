import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl, ValidationErrors, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [ReactiveFormsModule, RouterModule],
  templateUrl: './register.html',
  styleUrl: './register.scss',
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;
  isSubmitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.initForm();
  }

  initForm(): void {
    this.registerForm = this.formBuilder.group({
      fullName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required]
    }, { 
      // Ajout d'un validateur global au formulaire pour comparer les mots de passe
      validators: this.passwordMatchValidator 
    });
  }

  // Validateur personnalisé
  passwordMatchValidator(control: AbstractControl): ValidationErrors | null {
    const password = control.get('password')?.value;
    const confirmPassword = control.get('confirmPassword')?.value;
    
    // Si les mots de passe ne correspondent pas, on retourne une erreur 'mismatch'
    return password === confirmPassword ? null : { mismatch: true };
  }

  // Getter pratique
  get f() {
    return this.registerForm.controls;
  }

  onSubmit(): void {
    this.isSubmitted = true;

    if (this.registerForm.invalid) {
      return;
    }

    console.log('Nouvel utilisateur à inscrire :', this.registerForm.value);
    
    // Logique d'appel au service à ajouter ici...
    // Une fois l'inscription réussie, on redirige vers la connexion
    // this.router.navigate(['/login']);
  }
}