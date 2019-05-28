import { Component, OnInit } from '@angular/core';
import { ElectionService } from 'src/app/service/election.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { ResultService } from 'src/app/service/result.service';
import { CandidateResult } from 'src/app/model/candidate-result';
import { ElectionDTO } from 'src/app/model/election-dto';
import { Citizen } from 'src/app/model/citizen';

@Component({
  selector: 'app-result-list-voters',
  templateUrl: './result-list-voters.component.html',
  styleUrls: ['./result-list-voters.component.css']
})
export class ResultListVotersComponent implements OnInit {

  results: Citizen[] = [];
  electionId: number;

  constructor(

    private electionService: ElectionService,
    private router: Router,
    private authService: CustomeAuthService,
    private route: ActivatedRoute,
    private resultService: ResultService, ) { }

  ngOnInit() {
        const id = Number(this.route.snapshot.paramMap.get('id'));
        this.resultService.getCitizensVotedInElectionById(id).subscribe(results => {
          this.results = results;
        });
  }

}
