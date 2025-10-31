import { Component, Input, AfterViewInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Chart, ChartConfiguration, ChartType } from 'chart.js';

@Component({
  selector: 'app-chart',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './chart.html',
  styleUrls: ['./chart.css']
})
export class ChartComponent implements AfterViewInit {
  @Input() type: ChartType = 'bar';
  @Input() data: any;
  @Input() options: any;

  @ViewChild('canvas') canvas: any;

  chart: Chart | undefined;

  ngAfterViewInit() {
    if (this.canvas && this.data) {
      this.chart = new Chart(this.canvas.nativeElement, {
        type: this.type,
        data: this.data,
        options: this.options || { responsive: true, plugins: { legend: { position: 'top' } } }
      });
    }
  }
}
