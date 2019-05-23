import { Component, OnInit } from '@angular/core';
import { ElectionDTO } from 'src/app/model/election-dto';
import { ElectionService } from 'src/app/service/election.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CandidateDTO } from 'src/app/model/candidate-dto';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { Account } from 'src/app/model/account';
import { VoteService } from 'src/app/service/vote.service';
import { VoteDTO } from 'src/app/model/vote-dto';
import { Citizen } from 'src/app/model/citizen';

@Component({
  selector: 'app-vote-page',
  templateUrl: './vote-page.component.html',
  styleUrls: ['./vote-page.component.css']
})
export class VotePageComponent implements OnInit {


  election: ElectionDTO;
  selectedCandidate: CandidateDTO = null;
  currAccount: Account;
  canVote: boolean = false;

  constructor(
    private electionService: ElectionService,
    private router: Router,
    private route: ActivatedRoute,
    private authService: CustomeAuthService,
    private voteService: VoteService
  ) { }

  ngOnInit() {
    console.log("ffqwwf");
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (!this.authService.checkLoggedUser()) {
      this.router.navigate(['/signin']);
    }
    this.electionService.findbyid(id).subscribe(election => {
      this.election = election;
    });
    this.authService.getCurrentUser().subscribe(account => {
      this.currAccount = account;
      if (account.citizen) {
        this.voteService.isExisting(id, account.id).subscribe(alreadyVoted => this.canVote = !alreadyVoted);
      }
    });

  }

  onRadioChange(candidate: CandidateDTO) {
    this.selectedCandidate = candidate;
  }

  vote(): void {
    if (this.selectedCandidate != null && this.currAccount.citizen && this.canVote) {
      let citizen: Citizen = new Citizen();
      citizen.id = this.currAccount.id;

      let vote: VoteDTO = new VoteDTO();
      vote.candidate = this.selectedCandidate;
      vote.citizen = citizen;
      vote.electionId = this.election.id;
      this.voteService.create(vote).subscribe(vote => {
        this.router.navigate(['']);
      });
    }
  }


}
