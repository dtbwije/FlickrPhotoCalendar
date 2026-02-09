import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlickrAuthRedirect } from './flickr-auth-redirect';

describe('FlickrAuthRedirect', () => {
  let component: FlickrAuthRedirect;
  let fixture: ComponentFixture<FlickrAuthRedirect>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FlickrAuthRedirect]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FlickrAuthRedirect);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
