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