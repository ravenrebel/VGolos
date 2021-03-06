import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInPageComponent } from './components/sign-in-page/sign-in-page.component';
import { AccountsComponent } from './components/accounts/accounts.component';
import { SignUpPageComponent } from './components/sign-up-page/sign-up-page.component';
import { SignUpCitizenPageComponent } from './components/sign-up-citizen-page/sign-up-citizen-page.component';
import { CreateElectionPageComponent } from './components/create-election-page/create-election-page.component';
import { HomePageListOfElectionsComponent } from './components/home-page-list-of-elections/home-page-list-of-elections.component';
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
import { EditElectionComponent } from './components/edit-election/edit-election.component';
import { ResultListVotersComponent } from './components/result-list-voters/result-list-voters.component';
import { CreateCadidateComponent } from './components/create-cadidate/create-cadidate.component';
import { ResultVotedForWinnersComponent } from './components/result-voted-for-winners/result-voted-for-winners.component';

const routes: Routes = [
  { path: 'signin', component: SignInPageComponent },
  { path: 'accounts', component: AccountsComponent },
  { path: 'signup', component: SignUpPageComponent },
  { path: 'signup/citizen', component: SignUpCitizenPageComponent },
  { path: 'create', component: CreateElectionPageComponent },
  { path: '', component: HomePageListOfElectionsComponent },
  { path: 'elections/active', component: ListOfElectionsActiveComponent },
  { path: 'elections/completed', component: ListOfElectionsCompletedComponent },
  { path: 'result', component: ResultCitizenPageComponent },
  // { path: 'result/admin', component: ResultAdminPageComponent },
  // { path: 'result/statis', component: ResultStatisticsAverageAgePageComponent },
  { path: 'elections/:id/results/their-city', component: ResultVotersInTheirCityPageComponent },
  { path: 'elections/:id/vote', component: VotePageComponent },
  { path: 'elections/:id/candidates', component: CandidatesComponent },
  { path: 'voters', component: VotersComponent },
  { path: 'elections/:id/delete', component: DeleteElectionComponent },
  { path: 'elections/:id/edit', component: EditElectionComponent },
  { path: 'elections/:id/results', component: ResultCitizenPageComponent },
  { path: 'elections/:id/results/average', component: ResultStatisticsAverageAgePageComponent },
  { path: 'elections/:id/results/citizen', component: ResultListVotersComponent },
  { path: 'elections/:id/candidates/:id/create', component: CreateCadidateComponent },
  { path: 'elections/:id/results/winners', component: ResultVotedForWinnersComponent},
  { path: 'elections/:id/results/mn', component: ResultAdminPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
