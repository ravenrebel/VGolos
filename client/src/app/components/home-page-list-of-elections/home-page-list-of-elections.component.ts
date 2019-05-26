import { Component, OnInit } from '@angular/core';
import { Election} from 'src/app/model/election'
import { ElectionService } from 'src/app/service/election.service';
import { ElectionDTO } from 'src/app/model/election-dto';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { Router, ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-home-page-list-of-elections',
  templateUrl: './home-page-list-of-elections.component.html',
  styleUrls: ['./home-page-list-of-elections.component.css']
})
export class HomePageListOfElectionsComponent implements OnInit {

  elections: ElectionDTO[];
  signedIn: boolean = false;
  selectedElection: ElectionDTO = null;


  constructor(
    private electionService: ElectionService,
    private router: Router,
 
    private authService: CustomeAuthService,

    private route: ActivatedRoute,
    private tokenStorage: TokenStorageService,
   ) 
   {

  }

  ngOnInit() {
    this.electionService.findAll().subscribe(data =>
      {
        this.elections = data;
      });
  }

  logout(): void {
    this.authService.logout();
    this.signedIn = false;
    this.router.navigate(['']);
  }

  signIn(): void {
    this.router.navigate(['signin']);
  }
<<<<<<< HEAD
  goVote():void{
    this.router.navigate(['elections/:id/vote'])
=======

  vote(election: ElectionDTO): void {
    this.selectedElection = election;
    this.router.navigate(['elections/' + this.selectedElection.id + '/vote']);
>>>>>>> 6b469a60e96962b4661dc7b1b9f1571654edf8b5
  }
}
