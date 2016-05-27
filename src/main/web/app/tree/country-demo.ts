import {Component} from '@angular/core';
import {TreeView} from './tree-view.component';
import {TreeNode} from './tree-node';
import {Store} from './redux/store';
import {TreeNodeService} from './tree-node.service';

@Component({
    selector:'tree-view-demo',
    template:`<tree-view [root]="node"></tree-view>`,
    directives:[TreeView],
    providers:[Store,TreeNodeService]
})

export class CountryDemo{
    node:TreeNode = null;

    ngOnInit(){
        this.node = new TreeNode('root','./data/countries.json', '');
    }
}