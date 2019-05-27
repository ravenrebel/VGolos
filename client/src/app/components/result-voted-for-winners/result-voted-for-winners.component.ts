import { Component, OnInit } from '@angular/core';
import { CandidateResult } from 'src/app/model/candidate-result';
import { ActivatedRoute } from '@angular/router';
import { ResultService } from 'src/app/service/result.service';
import { CandidateAvg } from 'src/app/model/candidate-avg';
import { ElectionService } from 'src/app/service/election.service';
import { CandidateCitizen } from 'src/app/model/candidate-citizen';

@Component({
  selector: 'app-result-voted-for-winners',
  templateUrl: './result-voted-for-winners.component.html',
  styleUrls: ['./result-voted-for-winners.component.css']
})
export class ResultVotedForWinnersComponent implements OnInit {

  results: CandidateCitizen[] = [];
  results1: CandidateResult[] = [];
  minPercentage: number;
  electionId: number;

  constructor(
    private electionService: ElectionService,
    private route: ActivatedRoute,
    private resultService: ResultService,
  ) { }

  ngOnInit() {
    this.electionId = Number(this.route.snapshot.paramMap.get('id'));
    this.resultService.getResultsByElectionIdVotedForWinners(this.electionId).subscribe(results => {
      this.results = results;
    });
  }

}
