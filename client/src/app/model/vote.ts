import { Candidate } from './candidate';
import { Citizen } from './citizen';
import { Election } from './election';

export class Vote {
    id : number;
    candidate : Candidate;
    citizen : Citizen;
    election : Election;
    
}
