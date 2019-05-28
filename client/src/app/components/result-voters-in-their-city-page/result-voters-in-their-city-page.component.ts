import { Component, OnInit } from '@angular/core';
import { CandidateResult } from 'src/app/model/candidate-result';
import { ActivatedRoute } from '@angular/router';
import { ResultService } from 'src/app/service/result.service';
import { CandidateAvg } from 'src/app/model/candidate-avg';
import { ElectionService } from 'src/app/service/election.service';
import { CandidateTop } from 'src/app/model/candidate-top';
import { CandidateRegion } from 'src/app/model/candidate-region';

@Component({
  selector: 'app-result-voters-in-their-city-page',
  templateUrl: './result-voters-in-their-city-page.component.html',
  styleUrls: ['./result-voters-in-their-city-page.component.css']
})
export class ResultVotersInTheirCityPageComponent implements OnInit {

  results: CandidateRegion[] = [];
  electionId: number;

  constructor(
    private electionService: ElectionService,
    private route: ActivatedRoute,
    private resultService: ResultService
  ) { }

  ngOnInit() {
    this.electionId = Number(this.route.snapshot.paramMap.get('id'));
    this.resultService.getWinnerResultsByElectionId(this.electionId).subscribe(results => {
      this.results = results;

    });
  }

}
