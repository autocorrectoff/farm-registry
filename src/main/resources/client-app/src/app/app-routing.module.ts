import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FarmViewComponent } from './components/farm-view/farm-view.component';
import { AuthGuardGuard } from './guards/auth-guard.guard';
import { LoginComponent } from './components/login/login.component';


const routes: Routes = [
  {path: 'farms', component: FarmViewComponent, canActivate: [AuthGuardGuard]},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
