import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInPageComponent } from './components/sign-in-page/sign-in-page.component';
import { AccountsComponent } from './components/accounts/accounts.component';
import { SignUpPageComponent } from './components/sign-up-page/sign-up-page.component';

const routes: Routes = [
  { path: 'signin', component: SignInPageComponent },
  { path: 'accounts', component: AccountsComponent },
  { path: 'signup', component: SignUpPageComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
