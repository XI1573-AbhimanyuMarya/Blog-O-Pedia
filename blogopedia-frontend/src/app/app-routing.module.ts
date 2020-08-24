import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './auth/register/register.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './auth/login/login.component';


const routes: Routes = [
   {path: '',component:HeaderComponent},
   {path: 'login',component:LoginComponent},
  {path: 'signup',component:RegisterComponent}
   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
