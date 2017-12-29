import {Component, OnInit} from '@angular/core';
import {ExampleApi} from "@concrete/org/coodex/example";

@Component({
    selector: 'app-example',
    templateUrl: './example.component.html',
    styleUrls: ['./example.component.css']
})
export class ExampleComponent implements OnInit {

    private x1: number;
    private x2: number;

    constructor(private example: ExampleApi) {
    }

    ngOnInit() {
        this.x1 = 0;
        this.x2 = 0;
    }

    add(){
        this.example.add(this.x1,this.x2).subscribe(
            value => alert(this.x1 + " + " + this.x2 + " = " + value),
            (error) => alert(error));
    }

}
