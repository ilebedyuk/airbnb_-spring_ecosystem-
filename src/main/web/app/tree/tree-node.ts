export class TreeNode{
    showIcon: boolean = false;
    expanded: boolean = false;
    icon: string = null;

    constructor(public key: string, public url: string, public name: string){
        if(url){
            this.showIcon = true;
            this.icon = this.getIcon();
        }
    }

    expand(){
        this.expanded = !this.expanded;
        this.icon = this.getIcon();
    }

    private getIcon(): string {
        if (this.showIcon === true) {
            if(this.expanded){
                return '- ';
            }
            return '+ ';

        }
        return null;
    }
}