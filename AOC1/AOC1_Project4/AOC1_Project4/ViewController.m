//
//  ViewController.m
//  AOC1_Project4
//
//  Created by Joel Betterly on 7/26/12.
//  Copyright (c) 2012 Full Sail. All rights reserved.
//

#import "ViewController.h"
//declare login button for tag
#define LOGIN_BUTTON = 0  

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
    userNameTxt = [[UITextField alloc] initWithFrame:CGRectMake(100.0f, 8.0f, 200.0f, 30.0f)];
    if (userNameTxt != nil){
        userNameTxt.borderStyle = UITextBorderStyleRoundedRect;
        [self.view addSubview:userNameTxt];
    }
    
//3. Create a rounded rectangle UIButton of any color under the UITextField with the text "Login" on it.
    
    UIButton *loginTextButton = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    if (loginTextButton != nil){
     //   loginTextButton.tag = LOGIN_BUTTON;
        loginTextButton.frame = CGRectMake(225.0f, 45.0f, 75.0f, 35.0f);
        [loginTextButton setTitle:@"Login" forState:UIControlStateNormal];
        [loginTextButton addTarget:self action:@selector(onClick:) forControlEvents:UIControlEventTouchUpInside];
        loginTextButton.tintColor = [UIColor blueColor];
        [self.view addSubview:loginTextButton];
        
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
