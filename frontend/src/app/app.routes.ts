import { Routes } from '@angular/router';
import { LoginComponent } from './features/auth/pages/login/login';
import { RegisterComponent } from './features/auth/pages/register/register';
import { AdminDashboardComponent } from './dashboard/admin-dashboard/admin-dashboard';
import { AgentDashboardComponent } from './dashboard/agent-dashboard/agent-dashboard';
import { LogisticienDashboardComponent } from './dashboard/logisticien-dashboard/logisticien-dashboard';
export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'dashboard', component: AdminDashboardComponent },
  { path: 'agent-dashboard', component: AgentDashboardComponent },
  { path: 'logisticien-dashboard', component: LogisticienDashboardComponent },
  { path: '**', redirectTo: 'login' }];
