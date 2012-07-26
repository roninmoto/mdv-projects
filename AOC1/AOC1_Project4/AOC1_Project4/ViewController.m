//
//  ViewController.m
//  AOC1_Project4
//
//  Created by Joel Betterly on 7/26/12.
//  Copyright (c) 2012 Full Sail. All rights reserved.
//

#import "ViewController.h"
#define LOGIN_BUTTON 0 
#define DATE_BUTTON 1
#define INFO_BUTTON 2

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{

    
//////////////////////    
//Part I Steps 1-6 //
////////////////////
    
//1-Part I. Create a UILabel near the top of screen with Username in it.   
    
    UILabel *label = [[UILabel alloc] initWithFrame:CGRectMake(5.0f, 5.0f, 90.0f, 30.0f)];
    if (label !=nil){
        label.text =@"Username:";
    }
    [self.view addSubview:label];
    
//2-Part I. Create a UITextField to the right of the username label.
    
    userNameTxt = [[UITextField alloc] initWithFrame:CGRectMake(100.0f, 5.0f, 200.0f, 30.0f)];
    if (userNameTxt != nil){
        userNameTxt.borderStyle = UITextBorderStyleRoundedRect;
        [self.view addSubview:userNameTxt];
    }
    
//3-Part I. Create a rounded rectangle UIButton of any color under the UITextField with the text "Login" on it.
    
    UIButton *loginTextButton = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    if (loginTextButton != nil){
        loginTextButton.tag = LOGIN_BUTTON;
        loginTextButton.frame = CGRectMake(225.0f, 45.0f, 75.0f, 35.0f);
        [loginTextButton setTitle:@"Login" forState:UIControlStateNormal];
        [loginTextButton addTarget:self action:@selector(onClick:) forControlEvents:UIControlEventTouchUpInside];
        loginTextButton.tintColor = [UIColor blueColor];
        [self.view addSubview:loginTextButton];
        
//4-Part I. Create another UILabel beneath with the default text "Please Enter Username".
        
        loginTxt = [[UILabel alloc] initWithFrame:CGRectMake(1.0f, 90.0f, 330.0f, 70.0f)];
        if (loginTxt != nil){
            loginTxt.text = @"Please Enter Username";
            loginTxt.textAlignment = UITextAlignmentCenter;
            loginTxt.backgroundColor = [UIColor lightGrayColor];
        }
        [self.view addSubview:loginTxt];
        
    }
    
/////////////////////////    
//Part II Date Button //
///////////////////////
    
    
//1-Part II. Create a UIButton using the rounded reteangle type, give button any color.
    
    UIButton *dButton = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    if (dButton != nil){
        dButton.frame = CGRectMake(5.0f, 200.0f, 100.0f, 30.0f);
        
//2-Part II. Add text "Show Date" to button.  
        
        [dButton setTitle:@"Show Date" forState:UIControlStateNormal];
        
//3-Part II. Add an action to the button that when clicked, it will call the same onClick function.  Add a tag to the date button so you know when the button was pressed.
        
        dButton.tag = DATE_BUTTON;
        [dButton addTarget:self action:@selector(onClick:) forControlEvents:UIControlEventTouchUpInside];
        [self.view addSubview:dButton];
    }

/////////////////////////////////    
//Part III Information Button //
///////////////////////////////
    
    
//1-Part III. Create A UIButton using either the light or dark button and place at bottom of screen.
    
    UIButton *infoButton = [UIButton buttonWithType:UIButtonTypeInfoDark];
    if (infoButton != nil) {
        infoButton.frame = CGRectMake(5.0f, 280.0f, 25.0f, 25.0f);
        infoButton.tag = INFO_BUTTON;
        [infoButton addTarget:self action:@selector(onClick:) forControlEvents:UIControlEventTouchUpInside];
        [self.view addSubview:infoButton];
    }
    
//2-Part III. Create a UILabel beneath it that contains no inital text.    
    
    myData = [[UILabel alloc] initWithFrame:CGRectMake(5.0f, 310.0f, 300.0f, 70.0f)];
    if (myData != nil) {
    
    }
    [self.view addSubview:myData];
    
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}
//5-Part I. Add a target to the UIButton to call a function called onClick when the user presses the login button.

- (void)onClick:(UIButton*)button{
    
//6-Part I. If user enters no text, display message of usename cannot be empty... 
    
    if (button.tag == LOGIN_BUTTON  && userNameTxt.text == 0) {
        loginTxt.text = @"Username cannot be empty";
        loginTxt.textAlignment = UITextAlignmentCenter;
        loginTxt.textColor = [UIColor whiteColor];
        loginTxt.backgroundColor = [UIColor redColor];
        
//6a-Part I. Otherwise display user has been logged in.
        
    }else if (button.tag == LOGIN_BUTTON) {
        NSString *user = [[NSString alloc] initWithString:userNameTxt.text];
        loginTxt.text = [NSString stringWithFormat:@"User: '%@' has been logged in", user];
        loginTxt.backgroundColor = [UIColor grayColor];
        loginTxt.numberOfLines = 3;
        
//4-Part II. Display a UIAlertView with the current date and time displayed in the format seen in the dateAlert graphic.  You must use NSDAte object to gather the date and time info.
        
    }else if (button.tag == DATE_BUTTON) {
        NSDate *date = [NSDate date];
        NSDateFormatter *dateFormat = [[NSDateFormatter alloc] init];
        if (dateFormat !=nil) {
            [dateFormat setDateStyle:NSDateFormatterLongStyle];  //using built-in formatting instead of manually doing it.
            [dateFormat setTimeStyle:NSDateFormatterLongStyle];
            NSString* dateLabel = [dateFormat stringFromDate:date];
            UIAlertView *dateAlert = [[UIAlertView alloc] initWithTitle:@"Date & Time" message:dateLabel delegate:nil cancelButtonTitle:@"Ok" otherButtonTitles:nil];
            if (dateAlert != nil) {
                [dateAlert show];
            }
            
        }
        
//4-Part III. When buton is pressed have text read "This application was created by: First Last and have it appea in the uilabel.
        
    }else if (button.tag == INFO_BUTTON) {
        myData.text = @"This application was created by:          Joel Betterly";
        myData.textAlignment = UITextAlignmentCenter;
        myData.numberOfLines = 2;
    }
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
