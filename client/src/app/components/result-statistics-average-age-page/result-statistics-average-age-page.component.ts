import { Component, OnInit } from '@angular/core';
import { CandidateResult } from 'src/app/model/candidate-result';
import { ActivatedRoute } from '@angular/router';
import { ResultService } from 'src/app/service/result.service';
import { CandidateAvg } from 'src/app/model/candidate-avg';
import { ElectionService } from 'src/app/service/election.service';

@Component({
  selector: 'app-result-statistics-average-age-page',
  templateUrl: './result-statistics-average-age-page.component.html',
  styleUrls: ['./result-statistics-average-age-page.component.css']
})
export class ResultStatisticsAverageAgePageComponent implements OnInit {

  results: CandidateAvg[] = [];
  electionId: number;

  constructor(
    private electionService: ElectionService,
    private route: ActivatedRoute,
    private resultService: ResultService,

  ) { }

  ngOnInit() {
    this.electionId = Number(this.route.snapshot.paramMap.get('id'));
    this.resultService.getAvgAgeResultsByElectionId(this.electionId).subscribe(results => {
      this.results = results;
    }

    )
  }

}
