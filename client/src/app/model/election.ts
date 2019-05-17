import { Candidate } from './candidate';
import { Vote } from './vote';

export class Election {
    id : number;
    name : string;
    year : number;
    tour : number;
    beginningOfVoting : Date;
    endOfVoting : Date;
    candidates : Candidate[];
    votes : Vote[];
}
