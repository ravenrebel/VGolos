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
import { ResultService } from 'src/app/service/result.service';
import { CandidateTop } from 'src/app/model/candidate-top';


@Component({
  selector: 'app-result-citizen-page',
  templateUrl: './result-citizen-page.component.html',
  styleUrls: ['./result-citizen-page.component.css']
})
export class ResultCitizenPageComponent implements OnInit {

  candidateTop: CandidateTop;

  constructor(
    private electionService: ElectionService,
    private router: Router,
    private authService: CustomeAuthService,
    private route: ActivatedRoute,
    private resultService:ResultService,

   ) 
   {

  }
  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.resultService.getWinnerResultsByElectionId(id).subscribe(result =>
      {
      this.candidateTop[id] = result;
      });

}}
