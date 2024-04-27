import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlimalListComponent } from './alimal-list.component';

describe('AlimalListComponent', () => {
  let component: AlimalListComponent;
  let fixture: ComponentFixture<AlimalListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlimalListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AlimalListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
