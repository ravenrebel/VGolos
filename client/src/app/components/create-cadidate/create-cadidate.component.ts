import { Component, OnInit } from '@angular/core';
import { ElectionService } from 'src/app/service/election.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CandidateDTO } from 'src/app/model/candidate-dto';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { Account } from 'src/app/model/account';
import { Location } from '@angular/common';
import { CandidateControllerService } from 'src/app/service/candidate.service';
import { CitizenService } from 'src/app/service/citizen.service';
import { Citizen } from 'src/app/model/citizen';


@Component({
  selector: 'app-create-cadidate',
  templateUrl: './create-cadidate.component.html',
  styleUrls: ['./create-cadidate.component.css']
})
export class CreateCadidateComponent implements OnInit {

  currAccount: Account;
  candidate: CandidateDTO = new CandidateDTO();
  citizen: Citizen = new Citizen();

  constructor(
    private candidateService: CandidateControllerService,
    private citizenService: CitizenService,
    private router: Router,
    private route: ActivatedRoute,
    private authService: CustomeAuthService,
    private location:Location,
  ) { }

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.candidate.electionId=id;
    console.log(this.citizen.idn);
    
    if (!this.authService.checkLoggedUser()) {
      this.router.navigate(['/signin']);
    }
    this.citizenService.findByLogin(this.citizen.idn).subscribe(citizen => {
      this.citizen = citizen;
      console.log(this.citizen);
    });
  }

  create(): void {
    console.log(this.candidate);
    this.candidateService.create(this.candidate).subscribe(date => {
      this.router.navigate(['elections/' + this.candidate.electionId + '/candidates']);
    }
    );
  }

  goBack(): void{
    this.location.back();
  }
}
