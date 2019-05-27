import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ElectionDTO } from 'src/app/model/election-dto';
import { ElectionService } from 'src/app/service/election.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';


@Component({
  selector: 'app-edit-election',
  templateUrl: './edit-election.component.html',
  styleUrls: ['./edit-election.component.css']
})
export class EditElectionComponent implements OnInit {

  election: ElectionDTO;

  constructor(
    private router: Router,
    private location:Location,
    private electionService:ElectionService,
    private route: ActivatedRoute,
    private authService: CustomeAuthService,

  ) { 
    
  }

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (!this.authService.checkLoggedUser()) {
      this.router.navigate(['/signin']);
    }
    this.electionService.findbyid(id).subscribe(election => {
      this.election = election;
    });
  }
  
  edit(): void {
          console.log(this.election);
    this.electionService.update(this.election).subscribe( date =>
      {
        this.router.navigate(['']);
      }
      );
  }

  goBack(): void{
    this.location.back();
  }

}
