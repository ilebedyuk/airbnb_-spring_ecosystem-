import { Injectable }     from '@angular/core';

@Injectable()
export class Links{
    public domen = 'http://192.168.3.89:8080';
    public serviceUrl = '/alfresco/service/';
    public login = '/alfresco/service/api/login';
    // public ticket : string;
    public ticketKeys = '?alf_ticket=';
    public peopleUri = 'api/people';
}


