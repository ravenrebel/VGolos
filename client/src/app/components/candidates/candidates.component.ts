import { Component, OnInit } from '@angular/core';
import { CandidateDTO } from 'src/app/model/candidate-dto';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { ElectionDTO } from 'src/app/model/election-dto';
import { ElectionService } from 'src/app/service/election.service';

@Component({
  selector: 'app-candidates',
  templateUrl: './candidates.component.html',
  styleUrls: ['./candidates.component.css']
})
export class CandidatesComponent implements OnInit {

  candidates: CandidateDTO[];
  signedIn: boolean = false;
  election: ElectionDTO;
  

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
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (!this.authService.checkLoggedUser()) {
      this.router.navigate(['/signin']);
    }
    this.electionService.findbyid(id).subscribe(election => {
      this.election = election;
    });
  }

}
