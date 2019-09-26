import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KnowledgePageComponent } from './knowledge-page/knowledge-page.component';
import { SearchComponent } from './search/search.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HelpComponent } from './help/help.component';
import { PrivacyComponent } from './privacy/privacy.component';
import { LoginComponent } from './login/login.component';
import { DomainComponent } from './domainexpert/domainexpert.component';


const routes: Routes = [
  
  {path: 'content', component:KnowledgePageComponent},
  {path: 'privacy', component:PrivacyComponent},
  {path: 'help', component:HelpComponent},
  {path: 'contact', component:ContactUsComponent},
  {path: 'feedback', component:FeedbackComponent},
  {path: 'login', component:LoginComponent},
  {path: 'domainexpert', component:DomainComponent},
  {path:'', component:SearchComponent},
  {path:'', redirectTo:'',pathMatch:'full'}
];

@NgModule({
  
imports: [RouterModule.forRoot(routes, {
  onSameUrlNavigation: 'reload'
})],
  exports: [RouterModule]
})
export class AppRoutingModule { }