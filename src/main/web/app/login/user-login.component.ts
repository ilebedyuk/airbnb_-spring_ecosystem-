import { Component } from '@angular/core';

import { HeroListComponent } from './../usersList/hero-list.component';
import { HeroService }       from './../services/user.service';
import { Links } from './../model/links';
import { CountryDemo } from './../tree/country-demo';

@Component({
    selector: 'hero-login',
    templateUrl: 'app/login/user-login.component.html',
    styleUrls: ['app/login/user-login.component.css'],
    directives: [HeroListComponent, CountryDemo]
})
export class HeroLoginComponent {

    errorMessage: string;

    constructor (private heroService: HeroService, private links: Links ) {}

    getTicket (username: string, password: string): string {
        if (!username && !password) {return;}
        this.heroService.getTicket(username, password)
            .subscribe(
                ticket => {this.links.ticket = ticket},
                error =>  this.errorMessage = <any>error);
    }
}