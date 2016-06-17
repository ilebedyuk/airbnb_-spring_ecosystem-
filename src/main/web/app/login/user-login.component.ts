import { Component } from '@angular/core';

import { HeroListComponent } from './../usersList/hero-list.component';
import { HeroService }       from './../services/user.service';
import { Links } from './../model/links';

@Component({
    selector: 'hero-login',
    templateUrl: 'app/login/user-login.component.html',
    styleUrls: ['app/login/user-login.component.css'],
    directives: [HeroListComponent]
})
export class HeroLoginComponent {

    ticket: string = localStorage.getItem("ticket");

    errorMessage: string;

    constructor (private heroService: HeroService, private links: Links ) {}

    getTicket (username: string, password: string): string {
        if (!username && !password) {return;}
        this.heroService.getTicket(username, password)
            .subscribe(
                ticket => {localStorage.setItem("ticket", ticket);
                this.ticket = ticket},
                error =>  this.errorMessage = <any>error);
    }
}

{"search_type":"count","ignore_unavailable":true,"index":"ebk-metrics-*"}
{"size":0,"query":{"filtered":{"query":{"query_string":{"analyze_wildcard":true,"query":"beat.hostname:midsrvbal"}},"filter":{"bool":{"must":[{"range":{"@timestamp":{"gte":"1464873750005","lte":"1464877350005","format":"epoch_millis"}}}]}}}},"aggs":{"2":{"date_histogram":{"interval":"2s","field":"@timestamp","min_doc_count":0,"extended_bounds":{"min":"1464873750005","max":"1464877350005"},"format":"epoch_millis"},"aggs":{"4":{"avg":{"field":"fs.used"}}}}}}
