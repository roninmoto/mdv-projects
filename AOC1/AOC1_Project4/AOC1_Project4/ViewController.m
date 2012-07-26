//
//  ViewController.m
//  AOC1_Project4
//
//  Created by Joel Betterly on 7/26/12.
//  Copyright (c) 2012 Full Sail. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
//1. Create a UILabel near the top of screen with Username in it.    
    UILabel *label = [[UILabel alloc] initWithFrame:CGRectMake(5.0f, 5.0f, 90.0f, 30.0f)];
    if (label !=nil){
        label.text =@"Username:";
    }
    [self.view addSubview:label];    
//2. Create a UITextField to the right of the username label.
    userNameTxt = [[UITextField alloc] initWithFrame:CGRectMake(100.0f, 10.0f, 200.0f, 30.0f)];
    if (userNameTxt != nil){
        userNameTxt.borderStyle = UITextBorderStyleRoundedRect;
        [self.view addSubview:userNameTxt];
    }
    
    
    
    
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
    } else {
        return YES;
    }
}

@end
