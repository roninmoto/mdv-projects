//
//  ViewController.m
//  AOC1 Project3
//
//  Created by Joel Betterly on 7/16/12.
//  Copyright (c) 2012 Full Sail. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)viewDidAppear:(BOOL)animated{
    
//1. Create a function called Add.  This function will take two NSInterger values an return the result of an addition between them.
    
    NSInteger addFunc = [self firstNum:2 secondNum:3];
    NSLog(@"The result of adding two numbers together is %d.",addFunc);
}


//1. The Add Function

-(int)firstNum:(int)num1 secondNum:(int)num2{
    return num1 + num2;
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
