import { Component, OnInit } from '@angular/core';
import { ElectionService } from 'src/app/service/election.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { ResultService } from 'src/app/service/result.service';
import { CandidateResult } from 'src/app/model/candidate-result';
import { ElectionDTO } from 'src/app/model/election-dto';



@Component({
  selector: 'app-result-citizen-page',
  templateUrl: './result-citizen-page.component.html',
  styleUrls: ['./result-citizen-page.component.css']
})
export class ResultCitizenPageComponent implements OnInit {

  results: CandidateResult[] = [];
  electionId: number;
  minPercentage: number;
  elections: ElectionDTO[];
  selectedElection: ElectionDTO = null;

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
    theirCity(election: ElectionDTO): void {
      this.selectedElection = election;
      this.router.navigate(['/elections/' + this.selectedElection.id + '/results/their-city']);
    }


}
