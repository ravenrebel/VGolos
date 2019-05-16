import { Account } from './account';

export class Citizen extends Account {
    firstName : string;
    lastName : string;
    fathersName : string;
    dateOfBirth : Date;
    idn : string;
    region : string;
}
