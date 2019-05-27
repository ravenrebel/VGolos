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
import { CandidateResult } from 'src/app/model/candidate-result';


@Component({
  selector: 'app-result-citizen-page',
  templateUrl: './result-citizen-page.component.html',
  styleUrls: ['./result-citizen-page.component.css']
})
export class ResultCitizenPageComponent implements OnInit {

  results: CandidateResult[] = [];
  electionId: number;
  minPercentage: number;

  constructor(
    private electionService: ElectionService,
    private router: Router,
    private authService: CustomeAuthService,
    private route: ActivatedRoute,
    private resultService: ResultService,

  ) {}
  ngOnInit() {
    this.electionId = Number(this.route.snapshot.paramMap.get('id'));
    this.minPercentage = 0;
    this.refreshResults();
  }

  refreshResults(): void {
    this.resultService.getResultsByElectionId(this.electionId, this.minPercentage).subscribe(results => {
      this.results = results;
      console.log("changed");
    });
  }




}
