import { Citizen } from './citizen';
import { Election } from './election';

export class Candidate  {
    id : number;
    citizen : Citizen;
    election :Election;
}
