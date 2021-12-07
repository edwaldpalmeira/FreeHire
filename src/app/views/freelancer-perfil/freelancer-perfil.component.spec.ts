import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FreelancerPerfilComponent } from './freelancer-perfil.component';

describe('FreelancerPerfilComponent', () => {
  let component: FreelancerPerfilComponent;
  let fixture: ComponentFixture<FreelancerPerfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FreelancerPerfilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FreelancerPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
