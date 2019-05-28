import { Component, OnInit } from '@angular/core';
import { ResultService } from 'src/app/service/result.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ElectionService } from 'src/app/service/election.service';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { ElectionDTO } from 'src/app/model/election-dto';
import { CandidateTop } from 'src/app/model/candidate-top';


@Component({
  selector: 'app-result-admin-page',
  templateUrl: './result-admin-page.component.html',
  styleUrls: ['./result-admin-page.component.css']
})
export class ResultAdminPageComponent implements OnInit {

  results: CandidateTop[] = [];
  electionId: number;
  positionAmount: number;
  regionAmount: number;
  elections: ElectionDTO[];
  selectedElection: ElectionDTO = null;

  constructor(
    private electionService: ElectionService,
    private router: Router,
    private authService: CustomeAuthService,
    private route: ActivatedRoute,
    private resultService: ResultService,

  ) { }

  ngOnInit() {
  //   this.electionId = Number(this.route.snapshot.paramMap.get('id'));
  //   this.positionAmount = 1;
  //   this.regionAmount = 0;
  //   this.refreshResults();
  // }

  // refreshResults(): void {
  //   this.resultService.getTopResultsByElectionId(this.electionId, this.regionAmount, this.positionAmount).subscribe(results => {
  //     this.results = results;
  //     console.log("changed");
  //   });

  // }
}}
