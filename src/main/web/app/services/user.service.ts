import { Injectable }     from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';

import { User }           from './../model/user';
import { Links } from './../model/links';
import {Observable} from "rxjs/Rx";

@Injectable()
export class HeroService {

    private heroesUrl = this.links.domen + this.links.serviceUrl + this.links.peopleUri + this.links.ticketKeys;
    private loginUrl = this.links.domen + this.links.login;

    constructor (private http: Http, private links : Links) {}

    getHeroes() : Observable<User[]> {
        let heroesUrl = this.heroesUrl + localStorage.getItem("ticket");

        return this.http.get(heroesUrl)
            .map(heroes => this.extractData(heroes, localStorage.getItem("ticket"), this.links))
            .catch(this.handleError);
    }

    getTicket (username: string, password: string): Observable<string> {
        let body = JSON.stringify({ username,  password});
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http.post(this.loginUrl, body, options)
            .map(this.extractTicket)
            .catch(this.handleError);
    }

    private extractTicket(res: Response) {
        if (res.status < 200 || res.status >= 300) {
            throw new Error('Response status: ' + res.status);
        }
        let body = res.json();
        return body.data.ticket || {};
    }

    private extractData(res: Response, ticket: string, links: Links) {
        if (res.status < 200 || res.status >= 300) {
            throw new Error('Response status: ' + res.status);
        }

        let body = res.json();
        let serviceUrl = links.domen + links.serviceUrl;
        let ticketUrl = links.ticketKeys + ticket;

        for (let human of body.people) {
            human.avatar = human.avatar === undefined ? undefined : serviceUrl + human.avatar  + ticketUrl;
        }
        return body.people || [];
    }

    private handleError (error: any) {
        // In a real world app, we might use a remote logging infrastructure
        let errMsg = error.message || 'Server error';
        console.error(errMsg); // log to console instead
        return Observable.throw(errMsg);
    }
}