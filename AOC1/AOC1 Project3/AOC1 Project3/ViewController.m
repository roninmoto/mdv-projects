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
    
//1. Create a function called Add.  This function will take two int values and return the result of an addition between them.
    
    int addFunc = [self firstNum:2 secondNum:3];
    NSNumber *combinedResult = [[NSNumber alloc] initWithInt:addFunc];
    NSString *stringNum = [NSString stringWithFormat:@"The result is "];
    NSString *convertToString = [combinedResult stringValue];
    NSString *convertedString = [self part1:stringNum part2:convertToString]; //part1, part2 variables are pulled from append function
    [self displayAlertWithString:convertedString]; //displays the alert onscreen. Uses the append function to combine the result text to display with the values that were combined.
    

}


//1. The Add Function

-(int)firstNum:(int)num1 secondNum:(int)num2{
    return num1 + num2; // we added the two int's together and now return them.
}

//2. The Compare Function.

//3. The Append Function.
-(NSString *)part1:(NSString *)string1 part2:(NSString *)string2{
    NSMutableString *part1String = [NSMutableString stringWithString:string1];
    NSString *newString = [part1String stringByAppendingString:string2];
    return newString;
}


//4. Create the displayAlertWithString Function
// Wendy shows how to write this function in video 34.3_UIAlertIndicator.

-(void)displayAlertWithString:(NSString *)string{
    
    UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:@"Alert" message:string delegate:nil cancelButtonTitle:@"Okay" otherButtonTitles:nil, nil];
    if (alertView != nil){
        
        [alertView show];
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
