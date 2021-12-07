import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FreelancerCadastroComponent } from './freelancer-cadastro.component';

describe('FreelancerCadastroComponent', () => {
  let component: FreelancerCadastroComponent;
  let fixture: ComponentFixture<FreelancerCadastroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FreelancerCadastroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FreelancerCadastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
