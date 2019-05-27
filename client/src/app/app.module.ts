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
import { FooterComponent } from './components/footer/footer.component';
import { CreateElectionPageComponent } from './components/create-election-page/create-election-page.component';
import { HomePageListOfElectionsComponent } from './components/home-page-list-of-elections/home-page-list-of-elections.component';
import { VoteOfElectionPageComponent } from './components/vote-of-election-page/vote-of-election-page.component';
import { ListOfElectionsActiveComponent } from './components/list-of-elections-active/list-of-elections-active.component';
import { ListOfElectionsCompletedComponent } from './components/list-of-elections-completed/list-of-elections-completed.component';
import { ResultCitizenPageComponent } from './components/result-citizen-page/result-citizen-page.component';
import { ResultAdminPageComponent } from './components/result-admin-page/result-admin-page.component';
import { ResultStatisticsAverageAgePageComponent } from './components/result-statistics-average-age-page/result-statistics-average-age-page.component';
import { ResultVotersInTheirCityPageComponent } from './components/result-voters-in-their-city-page/result-voters-in-their-city-page.component';
import { VotePageComponent } from './components/vote-page/vote-page.component';
import { CandidatesComponent } from './components/candidates/candidates.component';
import { VotersComponent } from './components/voters/voters.component';
import { DeleteElectionComponent } from './components/delete-election/delete-election.component';

@NgModule({
  declarations: [
    AppComponent,
    SignInPageComponent,
    AccountsComponent,
    HeaderComponent,
    SignUpPageComponent,
    SignUpCitizenPageComponent,
    FooterComponent,
    CreateElectionPageComponent,
    HomePageListOfElectionsComponent,
    VoteOfElectionPageComponent,
    ListOfElectionsActiveComponent,
    ListOfElectionsCompletedComponent,
    ResultCitizenPageComponent,
    ResultAdminPageComponent,
    ResultStatisticsAverageAgePageComponent,
    ResultVotersInTheirCityPageComponent,
    VotePageComponent,
    CandidatesComponent,
    VotersComponent,
    DeleteElectionComponent
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
