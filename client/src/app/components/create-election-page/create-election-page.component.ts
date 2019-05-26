import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { ElectionDTO } from 'src/app/model/election-dto';
import { ElectionService } from 'src/app/service/election.service';


@Component(
  {
  selector: 'app-create-election-page',
  templateUrl: './create-election-page.component.html',
  styleUrls: ['./create-election-page.component.css']
}
)
export class CreateElectionPageComponent implements OnInit {

election: ElectionDTO = new ElectionDTO();

  constructor(
    private router: Router,
    private location:Location,
    private electionService:ElectionService


  ) { 
    
  }

  ngOnInit() {
    // const id = Number(this.ngRoute.snapshot.paramMap.get('id'));-
    // this.electionService.findbyid(id).subscribe...
  }
  
  create(): void {
          console.log(this.election);
    this.electionService.create(this.election).subscribe( date =>
      {
        this.router.navigate(['']);
      }
      );
  }

  goBack(): void{
    this.location.back();
  }

}
