import { Component, OnInit } from '@angular/core';
import { ElectionDTO } from 'src/app/model/election-dto';
import { ElectionService } from 'src/app/service/election.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { Account } from 'src/app/model/account';
import { Location } from '@angular/common';



@Component({
  selector: 'app-delete-election',
  templateUrl: './delete-election.component.html',
  styleUrls: ['./delete-election.component.css']
})
export class DeleteElectionComponent implements OnInit {

  election: ElectionDTO;
  currAccount: Account;
 
  constructor(
    private electionService: ElectionService,
    private router: Router,
    private route: ActivatedRoute,
    private authService: CustomeAuthService,
    private location:Location
  ) { }

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (!this.authService.checkLoggedUser()) {
      this.router.navigate(['/signin']);
    }
    this.electionService.findbyid(id).subscribe(election => {
      this.election = election;
    });
  }

  
  goBack(): void{
    this.location.back();
  }

  delete(): void {
    this.electionService.delete(this.election.id).subscribe(element => {
      this.router.navigate(['']);
    });
  }
}