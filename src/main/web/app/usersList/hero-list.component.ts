import { Component, OnInit, Input } from '@angular/core';

import { User }              from './../model/user';
import { HeroService }       from './../services/user.service.ts';

@Component({
    selector: 'hero-list',
    templateUrl: 'app/usersList/hero-list.component.html',
    styles: ['.error {color:red;}']
})
export class HeroListComponent implements OnInit {

    // @Input() ticket: string;
    errorMessage: string;
    heroes:User[];

    constructor (private heroService: HeroService) {}

    // ngOnInit() {
    //     if (!this.ticket) {return;}
    //     this.getHeroes(this.ticket);
    // }
    
    ngOnInit() {
        if (!localStorage.getItem("ticket")) {return;}
        this.getHeroes();
    }

    getHeroes() {
        this.heroService.getHeroes()
            .subscribe(
                heroes => this.heroes = heroes,
                error =>  this.errorMessage = <any>error);
    }

    //addHero (name: string) {
    //    if (!name) {return;}
    //    this.heroService.addHero(name)
    //        .subscribe(
    //            hero  => this.heroes.push(hero),
    //            error =>  this.errorMessage = <any>error);
    //}
}