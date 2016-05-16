/**
 * Created by thiago.oliveira on 16/05/2016.
 */
import {Component, bootstrap, View} from "angular2/angular2";

@Component({
    selector: 'my-app'
})
@View({
    template: '<h1>Hello {{ name }}</h1>'
})
class MyAppComponent {
    name: string;

    constructor() {
        this.name = 'Alice';
    }
}

bootstrap(MyAppComponent);