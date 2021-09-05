import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Filter } from 'src/app/model/filter.model';
import { OfferRes } from 'src/app/model/offerRes.model';
import { DataService } from 'src/app/services/data.service';
import { OfferService } from 'src/app/services/offer.service';

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {

  // subscription: Subscription;
  offers: Array<OfferRes> = [];
  row1: Array<OfferRes> = [];
  row2: Array<OfferRes> = [];

  page = 0;
  size = 5;
  totalPages = 0;

  currentPage = 0;
  disablePrevious = true;
  disableNext = false;

  error = false;

  rest = false;

  which = "";

  constructor(
    private offerService: OfferService,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar,
    ) { }

  async ngOnInit() {
    this.which = this.route.snapshot.paramMap.get('which');
    await this.loadOffers();
  }

  async loadOffers() {
    await this.offerService.getAll(this.page, this.size, this.which).then(
      res => {
        // console.log(res)
        this.error = false;

        this.row1 = [];
        this.row2 = [];

        if (res.numberOfElements >= res.totalElements) this.disableNext = true;
        this.totalPages = res.totalPages;

        this.offers = res.content

        var help = true;

        for (var o of this.offers) {
          if (help) this.row1.push(o);
          else this.row2.push(o);

          if (help) help = false;
          else help = true;
        }

        // console.log(this.row1)
        // console.log(this.row2)

        if ((res.numberOfElements % 2) == 1) {
          this.rest = true;
        }
        else this.rest = false;
      }, err => {
        if (err.status == 504) {
          this.openSnackBar('You are offline! Go online to access another page.');
          this.error = true;
        }
      }
    )
  }

  async next() {
    this.page = this.page + 1;
    await this.loadOffers();

    if (this.error == true) {
      // console.log("error je true u next")
      this.page = this.page - 1;
    } else {
      // console.log("error nije true u next")
      this.disablePrevious = false;
      if ((this.page + 1) == this.totalPages) this.disableNext = true;
    }
  }

  async previous() {
    this.page = this.page - 1;
    await this.loadOffers();

    if (this.error == true) {
      this.page = this.page + 1;
    } else {
      if (this.page == 0) this.disablePrevious = true;
      if ((this.page + 1) < this.totalPages) this.disableNext = false;
    }
  }

  openSnackBar(message: string): void {
    this.snackBar.open(message, 'Dismiss', {
      duration: 4000,
    });
  }

  ngOnDestroy() {
    // this.subscription.unsubscribe();
  }

}
