import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-help',
  templateUrl: './help.component.html',
  styleUrls: ['./help.component.css']
})
export class HelpComponent implements OnInit {
  images = [
    { img: "/assets/images/screen1.png"  },
    { img: "/assets/images/screen2.png"  },
    { img: "/assets/images/screen3.png"  },
    { img: "/assets/images/screen7.png"  },
    { img: "/assets/images/screen5.png"  },
    { img: "/assets/images/screen4.png"  },
    { img: "/assets/images/screen6.png"  },
    
   ];
  constructor() { }

  ngOnInit() {
  }

}
