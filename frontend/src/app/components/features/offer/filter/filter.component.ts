import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {

  val = "asd"
  subscription: Subscription;

  constructor(
    private data: DataService,
  ) { }

  ngOnInit(): void {
    this.subscription = this.data.currentMessage.subscribe(message => this.val = message)
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  /**
   * Saljemo poruku na drugu komponentu
   */
  send() {
    this.data.changeMessage(this.val)
  }

}
