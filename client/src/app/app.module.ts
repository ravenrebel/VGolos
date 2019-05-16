import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { SignInPageComponent } from './components/sign-in-page/sign-in-page.component';
import { AccountsComponent } from './components/accounts/accounts.component';
import { HttpClientModule }    from '@angular/common/http';
import { httpInterceptorProviders } from './service/auth-interceptor.service';
import { HeaderComponent } from './components/header/header.component';
import { SignUpPageComponent } from './components/sign-up-page/sign-up-page.component';
import { SignUpCitizenPageComponent } from './components/sign-up-citizen-page/sign-up-citizen-page.component';

@NgModule({
  declarations: [
    AppComponent,
    SignInPageComponent,
    AccountsComponent,
    HeaderComponent,
    SignUpPageComponent,
    SignUpCitizenPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    httpInterceptorProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
